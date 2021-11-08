kubectl create namespace vault
helm repo add hashicorp https://helm.releases.hashicorp.com
helm install vault hashicorp/vault \    
--namespace vault \    
--set "server.dev.enabled=true" \
--dry-run