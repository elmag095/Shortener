Create TABLE shortened_urls (
                            id varchar primary key ,
                            title varchar,
                            original_url varchar,
                            create_at date default now()
)