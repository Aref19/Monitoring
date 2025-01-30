FROM grafana/grafana:latest

# Copy your local grafana data
COPY ./grafana-data /var/lib/grafana

# Ensure proper permissions
USER root
RUN chown -R 472:472 /var/lib/grafana
USER 472