## This is example work with http://automationpractice.com site. 

## Requirements:
- Use any *object-oriented language* .
- Use Selenium WebDriver for web interactions
- Use automation patterns like *PageObject*, *data-driven* tests, etc.
- Use any testing frameworks. 
- provide code and clear instructions how to run it.

**Note**: please put your code in public repository.

**Note**: Please send link to this repo when you are done.

You will need the following technologies available to try it out:
* Git
* Gradle 3+
* JDK 8
* IDE of your choice 
* Web browser Chrome

### Ho w to run

```./gradlew clean test -Denv=test```

- [x] ability to run tests for different browsers/os by configuring;
- [x] ability to run tests for different environments(urls) by configuring/by command-line.

```./gradlew clean test -Denv=prod -Dbrowser=firefox``` 

### Generate Allure report 

```./gradlew allureReport```

### Open Allure report in browser

```./gradlew allureServe```


![](https://a.radikal.ru/a16/2105/f5/707a00f06e51.png)

![](https://d.radikal.ru/d01/2106/3a/78d8e9a91598.png)

![](https://b.radikal.ru/b17/2106/5e/db7a2106169d.png)



