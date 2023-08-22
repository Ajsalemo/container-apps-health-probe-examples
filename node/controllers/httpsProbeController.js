import express from "express";

const router = express.Router();
const httpsProbeResponseCode = process.env.HTTPS_PROBE_RESPONSE_CODE || 200

export const httpsProbeController = router.get("/", (req, res) => {
    try {
        console.log("Receving request from an HTTPS probe..")
        console.log(req.headers)
        res.status(httpsProbeResponseCode).send({ "msg": "HTTPS probe" })
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})

 