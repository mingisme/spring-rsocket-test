wget -O rsc.jar https://github.com/making/rsc/releases/download/0.9.1/rsc-0.9.1.jar

# To make the client easier to wirk with, set an alias
alias rsc='java -jar rsc.jar'

# To use the client to do request-response against a server on tcp://localhost:7001
rsc --debug --request --data "{\"origin\":\"Client\",\"interaction\":\"Request\"}" --route request-response tcp://localhost:7001

# To use the client to do fire-and-forget against the same server
rsc --debug --fnf --data "{\"origin\":\"Client\",\"interaction\":\"Fire And Forget\"}" --route fire-and-forget tcp://localhost:7001