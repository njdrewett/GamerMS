## Gamer Orchestration

## Run up the DynamoDB Containers before running the spring application. 


_docker-compose up -d_

if not persisting dbadamin data:


path=%path%;C:\Program Files\Amazon\AWSCLIV2
connect using:
aws dynamodb <command> --endpoint-url http://localhost:8000
e.g.
aws dynamodb list-tables --endpoint-url http://localhost:8000
(needs credentials) needs secret and key set but isnt used.  

Admin console
npm install -g dynamodb-admin
// For Windows
set DYNAMO_ENDPOINT=http://localhost:8000
dynamodb-admin
