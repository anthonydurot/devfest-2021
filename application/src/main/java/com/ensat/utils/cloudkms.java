import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.LocationName;
import java.io.IOException;

public class cloudkms {

  public void quickstart() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    quickstart(projectId, locationId);
  }

  public void quickstart(String projectId, String locationId) throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the parent from the project and location.
      LocationName parent = LocationName.of(projectId, locationId);

      // Call the API.
      ListKeyRingsPagedResponse response = client.listKeyRings(parent);

      // Iterate over each key ring and print its name.
      System.out.println("key rings:");
      for (KeyRing keyRing : response.iterateAll()) {
        System.out.printf("%s%n", keyRing.getName());
      }
    }
  }
}