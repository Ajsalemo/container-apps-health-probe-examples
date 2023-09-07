from flask import Flask, jsonify, request

import time

app = Flask(__name__)

@app.route("/")
def index():
    return jsonify({ "msg": "container-apps-health-probe-examples-python" })


@app.route("/probe/http")
def httpController():
    print("Receiving request from an HTTP probe..")
    print(dict(request.headers))
    return jsonify({ "msg": "HTTP probe" })


@app.route("/probe/https")
def httpsController():
    print("Receiving request from an HTTPS probe..")
    print(dict(request.headers))
    return jsonify({ "msg": "HTTPS probe" })