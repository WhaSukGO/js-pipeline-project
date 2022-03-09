def buildApp() {
	echo '[MSG] Building application ...'
}

def testApp() {
	echo '[MSG] Testing application ...'
}

def deployApp() {
	echo '[MSG] Deploying application ...'
	echo "Deplyoment version : ${params.VERSION}"
}
return this