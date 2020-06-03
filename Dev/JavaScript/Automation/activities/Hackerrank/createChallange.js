let fs = require("fs");
require("chromedriver");
let swd = require("selenium-webdriver");
let bldr = new swd.Builder();
let driver = bldr.forBrowser("chrome").build();
let credentials = process.argv[2];
let uToAdd = process.argv[3];

await driver.manage().setTimeouts({ implicit: 10000, pageLoad: 10000 })


async function main() {
    await login();
}

async function login() {
    let data = await fs.promises.readFile(credentials);
    let { url, pwd, user } = JSON.parse(data);
    
    await driver.get(url);
   
    let usernameElement = driver.findElement(swd.By.css('#input-1'));
    let passwordElement = driver.findElement(swd.By.css('#input-2'));

    let loginElements = await Promise.all([usernameElement, passwordElement]);
    
    let sendUsernamePromise = loginElements[0].sendKeys(user);
    let sendPasswordPromise = loginElements[1].sendKeys(pwd);
    
    await Promise.all([sendUsernamePromise, sendPasswordPromise]);
    
    let loginBtn = await driver.findElement(swd.By.css("button[data-analytics=LoginPassword"));
    await loginBtn.click();
    console.log("Logged in successfully !!")
}

main()