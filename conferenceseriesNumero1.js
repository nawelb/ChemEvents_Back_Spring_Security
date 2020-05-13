//load in puppeteer 
const puppeteer = require('puppeteer')
const fs = require('fs')

const SUB_URL = () => 'https://massspectrometrycongress.insightconferences.com/'

const self ={
 
    browser: null,
    page: null, 
    
    
    initialize: async () => {
        self.browser = await puppeteer.launch({
            headless: false
        });

        self.page = await self.browser.newPage();
      
        //Go to the subscf
        await self.page.goto(SUB_URL(), {waitUntil: 'networkidle0'});  
        
        await self.page.screenshot({path:'./Scrapping/screenshots/confSeriesNum1.png'});        
        //await self.page.pdf({path: './pdfs/chemConf.pdf'});
    }, 
   
    parseResult: async () => {
        
        let element = await self.page.$$('div[id^="mainPageContent"]'); 
        let results = [];
        let welcome = null;           
            try {

                welcome = await element.$eval(('header > nav > div[class="navbar-header"] > a'), node => node.getAttribute('href')); 
                //welcome = await element.$eval(('#section_Welcome'), node => node.innerText.trim());
                



            } catch (error) {
                //null;
                welcome;
            }
                            
        self.page.close();

        results.push(
            welcome
        )
        return results;
    
        } 

         
        
}
module.exports = self;