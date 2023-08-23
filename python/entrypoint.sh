#!/bin/bash

gunicorn -b 0.0.0.0:8000 app:app --timeout 600 --access-logfile "-" --error-logfile "-" & \
    gunicorn -b 0.0.0.0:8443 app:app --timeout 600 --access-logfile "-" --error-logfile "-" --certfile /app/certs/example.com.crt --keyfile /app/certs/example.com.key