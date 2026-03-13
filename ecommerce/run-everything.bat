@echo off
echo [1/3] Starting Docker Container...
docker compose up -d

echo [2/3] Waiting for Database (15s)...
timeout /t 15 /nobreak > nul

echo [3/3] Checking Database 'ecommerce'...
:: check database exist or not and create
docker exec postgres-ecommerce psql -U ecommerce -tc "SELECT 1 FROM pg_database WHERE datname = 'ecommerce'" | findstr /R "1" > nul
if %errorlevel% neq 0 (
    echo Creating database 'ecommerce'...
    docker exec postgres-ecommerce psql -U ecommerce -c "CREATE DATABASE ecommerce;"
) else (
    echo Database 'ecommerce' already exists.
)

echo --------------------------------------------------
echo SUCCESS: Docker and Database are ready.
echo Entering PostgreSQL Shell for 'ecommerce'...
echo --------------------------------------------------

:: run the docker directly to the ecommerce
docker exec -it postgres-ecommerce psql -U ecommerce -d ecommerce

pause