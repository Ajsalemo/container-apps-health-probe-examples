package controllers

import (
    "github.com/gofiber/fiber/v2"
)

type HomeResponse struct {
	Msg string
  }

func HomeController(c *fiber.Ctx) error {
	res := HomeResponse{
		Msg: "container-apps-health-probe-examples-go",
	}
	return c.JSON(res)
}