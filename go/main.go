package main

import (
    "log"
    "fmt"

    "github.com/gofiber/fiber/v2"

    controllers "github.com/azureossd/container-apps-health-probe-examples/go/controllers"
)

func main() {
    app := fiber.New()

    app.Get("/", controllers.HomeController)
    app.Get("/probe/http", controllers.HttpController)
    app.Get("/probe/https", controllers.HttpsController)

    // Start the servers concurrently through goroutines
    go func () {
        fmt.Println("Go Fiber starting HTTP server on port 3000..")
        log.Fatal(app.Listen(":3000"))
    }()

    fmt.Println("Go Fiber starting HTTPS server on port 3443..")
    log.Fatal(app.ListenTLS(":3443", "./certs/example.com.crt", "./certs/example.com.key"))
}