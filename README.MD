## Step 1 :: Build docker image

```
$mvnw clean package
$docker-compose build
```

Upload to Docker registry (Docker Hub)

```
$docker login
$docker image push somkiat/company-service
$docker image push somkiat/department-service
```

## Step 2 :: Deploy MongoDB on Kubernetes

```
$cd deployment
$kubectl create -f mongodb-configmap.yml
$kubectl create -f mongodb-secret.yml
$kubectl create -f mongodb-deployment.yml
$kubectl create -f mongodb-service.yml

$kubectl get pod,deploy,rs,svc
```

## Step 3 :: Deploy Company service on Kubernetes

```
$cd deployment
$kubectl create -f role.yml
$kubectl create -f company-deployment.yml
$kubectl create -f company-service.yml

$kubectl get pod,deploy,rs,svc
```

## Step 4 :: Deploy Department service on Kubernetes

```
$cd deployment
$kubectl create -f department-deployment.yml
$kubectl create -f department-service.yml

$kubectl get pod,deploy,rs,svc
```

## Step 5 :: Deploy Ingress controller on Kubernetes

```
$cd deployment
$kubectl create -f ingress.yml

$kubectl get ingress

NAME                HOSTS     ADDRESS          PORTS     AGE
gateway-ingress     *         35.244.231.86    80        37m
```





