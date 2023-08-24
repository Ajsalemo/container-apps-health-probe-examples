package controllers

import (
    "github.com/gofiber/fiber/v2"
	"fmt"
)

type HttpResponse struct {
	Msg string
  }

func HttpController(c *fiber.Ctx) error {
	res := HttpResponse{
		Msg: "HTTP probe",
	}
	fmt.Println("Receiving request from an HTTP probe..")
	fmt.Println(c.GetReqHeaders())

	return c.JSON(res)
}