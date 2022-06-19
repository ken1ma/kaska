## Build environment

1. Linux / latest macOS / Windows 10
2. Java 11.0.7 LTS
3. [sbt](https://www.scala-sbt.org/) 1.3.10

	1. On macOS, [Homebrew](https://brew.sh/) can be used to install one

			brew install sbt

4. [Node.js](https://nodejs.org/) 12.16.1 LTS and [npm](https://www.npmjs.com/)
	1. On macOS, [Homebrew](https://brew.sh/) can be used to install one

			brew install node@12

        1. Since node@12 is keg-only, PATH needs to be modified

                export PATH="/usr/local/opt/node@12/bin:$PATH"

		2. `npm` 6.13.4 is bundled with Node.js 12.16.1

	2. `npm` should probably be replaced with `yarn` for [security concerns](https://www.ryadel.com/en/yarn-vs-npm-pnpm-2019/)


# Development procedures

## Building and running locally

Start `sbt`

1. Build and run the server

		server/run

2. Build the client, from another `sbt` instance (different terminal)

		fastOptJS

	1. Open https://localhost:8443/ in a browser to run the client
		* see [extra doc](conf/gmo-coming.localsrv-README.md) if accessing GMO Payment Gateway
	2. `~fastOptJS` to recompile and `less` everytime the input files change
	3. `npm install` is run unless `node_modules` directory is present
	4. The JavaScript is not fully optimized


## Misc

1. Run the server unit tests

		server/test

1. List dependencies that can be updated

		dependencyUpdates
