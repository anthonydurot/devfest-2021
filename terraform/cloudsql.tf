resource "google_sql_database" "database" {
  name     = "devfest_database"
  instance = google_sql_database_instance.instance.name
}

resource "google_sql_database_instance" "instance" {
  name   = "new-2-devfest-database-instance"
  region = "us-central1"

  #depends_on = [google_service_networking_connection.private_vpc_connection]
  
  settings {
    disk_size = 10
    ip_configuration {
      ipv4_enabled = false
      private_network = google_compute_network.vpc.self_link
    }
    tier = "db-f1-micro"
  }

  deletion_protection  = "false"
}

resource "google_sql_user" "users" {
    name = "root"
    instance = "${google_sql_database_instance.instance.name}"
    host = "%"
    password = "password"
}

