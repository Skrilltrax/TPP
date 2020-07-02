const electron = require('electron')
const ejs = require('ejs-electron')

const { app, BrowserWindow } = require('electron')

ejs.data({
  "rows": 100,
  "cols": 26
})

function createWindow () {
  // Create the browser window.
  let win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      nodeIntegration: true
    }
  })

  // and load the index.html of the app.
  win.loadFile('html/index.ejs')
}

app.whenReady().then(createWindow)