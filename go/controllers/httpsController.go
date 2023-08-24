package controllers

import (
    "github.com/gofiber/fiber/v2"
	"fmt"
)

type HttpsResponse struct {
	Msg string
  }

func HttpsController(c *fiber.Ctx) error {
	res := HttpsResponse{
		Msg: "HTTPS probe",
	}
	fmt.Println("Receiving request from an HTTPS probe..")
	fmt.Println(c.GetReqHeaders())

	return c.JSON(res)
}