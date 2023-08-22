import express from "express";
import https from "https"
import fs from "fs"
import { homeController } from "./controllers/homeController.js";
import { httpProbeController } from "./controllers/httpProbeController.js";
import { httpsProbeController } from "./controllers/httpsProbeController.js";

const port = process.env.PORT || 3000;
const httpsPort = 8443;
const app = express()
const options = {
    key: fs.readFileSync("./certs/example.com.key"),
    cert: fs.readFileSync("./certs/example.com.crt"),
  };

app.use(homeController)
app.use("/probe/http", httpProbeController)
app.use("/probe/https", httpsProbeController)

app.listen(port, () => {
    console.log(`Server listening on port ${port}`)
})
// Listen for HTTPS requests
https.createServer(options, app).listen(httpsPort, () => {
    console.log(`Server listening on port ${httpsPort}`)
});

