Prepare environment:
run this in terminal:( or start docker-compose up -d )
docker run -d --name pgvector -e POSTGRES_USER=app -e POSTGRES_PASSWORD=password -e POSTGRES_DB=demo -p 5432:5432 pgvector/pgvector:pg18-trixie 
docker run -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama
# Wait a few seconds for the containers to start up
run following commands to pull models:
docker exec -it ollama pull mxbai-embed-large
docker exec -it ollama pull llama3.1:8b1 

Run RAG indexing: curl http://localhost:8080/index

