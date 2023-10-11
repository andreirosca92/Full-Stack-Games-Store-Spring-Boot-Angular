set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE DATABASE games_shop_db;
    CREATE USER games WITH ENCRYPTED PASSWORD 'hello';
    GRANT ALL PRIVILEGES ON DATABASE games TO games_shop_db;
EOSQL