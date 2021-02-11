wrk.method = "POST"
wrk.body = '{"query":"query {\\n  findFiatDepositByRequestId(requestId: \\"123\\") {\\n    requestId\\n    id\\n    header\\n  }\\n}"}'
wrk.headers["Content-Type"] = "application/json"

