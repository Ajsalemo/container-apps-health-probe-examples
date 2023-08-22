import express from "express";

const router = express.Router();
const httpProbeResponseCode = process.env.HTTP_PROBE_RESPONSE_CODE || 200

export const httpProbeController = router.get("/", (req, res) => {
    try {
        console.log("Receving request from an HTTP probe..")
        console.log(req.headers)
        res.status(httpProbeResponseCode).send({ "msg": "HTTP probe" })
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})