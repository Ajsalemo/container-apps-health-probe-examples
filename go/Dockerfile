FROM golang:1.21.0-alpine3.18

WORKDIR /app

# Download Go modules
COPY go.mod go.sum ./
RUN go mod download

COPY . ./

# Build
RUN CGO_ENABLED=0 GOOS=linux go build -o /usr/local/bin/app

EXPOSE 3000 3443

# Run
CMD ["/usr/local/bin/app"]