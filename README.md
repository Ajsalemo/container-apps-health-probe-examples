# container-apps-health-probe-examples

To run any of these examples:
- Build the `Dockerfile` in the root of the project and push it to your container registry
- set the required environment variables in the `arm-deploy/deploy.sh` file. Then run the command within the `arm-deploy/deploy.sh` or run the `deploy.sh` file directly from _within_ the `arm-deploy` directory.

> **NOTE**: This example **only* deploys a Container App via ARM. It doesn't create a Container App Environment. A Container App Environment must already exist first.

- This example exposes both HTTP and HTTPS ports to be accessible to Health Probes
- The `certs` directory contains a self-signed certificate to help enable HTTPS endpoints on the application for HTTPS Health Probe configuration
    - Applications are reachable over both HTTP and HTTPS with their respective exposed ports
    - Note, the browser may show a "certificate" warning due to self-signed usage on `localhost` - this is not a problem
- In the `ContainerAppConsoleLogs_CL` table, you'll see the below output - the output may vary depending on the language:

```
Receving request from an HTTPS probe..
{
    host: '100.100.0.5:8443',
    'user-agent': 'kube-probe/1.25',
    accept: '*/*',
    probe: 'Liveness',
    connection: 'close'
}

Receving request from an HTTP probe..
{
    host: '100.100.0.5:3000',
    'user-agent': 'kube-probe/1.25',
    accept: '*/*',
    probe: 'Readiness',
    connection: 'close'
}

Receving request from an HTTP probe..
{
    host: '100.100.0.5:3000',
    'user-agent': 'kube-probe/1.25',
    accept: '*/*',
    probe: 'Startup',
    connection: 'close'
}
```