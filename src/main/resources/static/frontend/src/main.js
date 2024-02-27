import { createApp } from 'vue'
import App from './App.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"

let app = createApp(App)

app.config.globalProperties.$hostName = process.env.NODE_ENV === 'development'
? 'http://localhost:8080'
: window.location.protocol + '//' +  window.location.hostname + ':' + window.location.port,

app.mount('#app')
