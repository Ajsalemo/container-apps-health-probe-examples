import express from "express";

const router = express.Router();

export const homeController = router.get("/", (_req, res) => {
    try {
        res.json({ "msg": "container-apps-health-probe-examples-node-http" })
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})