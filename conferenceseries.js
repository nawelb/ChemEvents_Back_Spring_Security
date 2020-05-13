//load in puppeteer 
const puppeteer = require('puppeteer')
const fs = require('fs')

const SUB_URL = () => 'https://www.conferenceseries.com/chemistry-meetings'

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
        
        await self.page.screenshot({path:'./Scrapping/screenshots/confSeries.png'});        
        //await self.page.pdf({path: './pdfs/chemConf.pdf'});
    }, 


    getResults: async() =>{

        let pagenumber = await self.page.$$('ul');
        let listePage = [];

        for (let pageN in pagenumber){
            let numeroPage = await pageN.$eval(('li'), node => node.innerText.trim()); 
            listePage.push({
              numeroPage  
            })
        }

        console.log(listePage);
       
    },

    parseResult: async () => {

        let elements = await self.page.$$('div[class="col-md-4 col-sm-6 col-xs-12 confer"]'); 
        let results = [];

        for (let element of elements){
            //Element general 
                let title1 = null;
                let siteWeb = null; 
                let date = null; 
                let lieu = null;
 
                    try{
                        title1 = await element.$eval(('a'), node => node.getAttribute('title'));
                        siteWeb = await element.$eval(('a'), node => node.getAttribute('href'));               
                        date = await element.$eval(('time'), node => node.innerText.trim());
                        lieu = await element.$eval(('address'), node => node.innerText.trim());
                    }catch{
                        title1;
                        siteWeb;  
                        date;  
                        lieu;
                    }

                    self.page = await self.browser.newPage();
      
            //Go to the link
                   
                   
                    let cpWelcome = null;



                    try {

                       //await self.page.goto(siteWeb, {waitUntil: 'networkidle0'});  
                       //await self.page.screenshot({path:'./Scrapping/screenshots/${title1}.png'});
                       
                       //let completePage = await self.page.$$('div[class="conf-content-main"]'); 
                       //cpWelcome = await completePage.$eval(('div[class="conf-content"] > div > div[class="tab-content"] > div[id="section_Welcome Message "]'), node => node.innerText.trim());
                       console.log("ok");





                    } catch (error) {
                        //null;
                        cpWelcome;
                    }
                   
              //Scrape Content
                    //let completePage = await self.page.$$('div[id="mainPageContent"]'); 
                    //let cpWelcome = null;
                    //let cpAbout = null;
                    //let cpSessionsTracks = null;

                    try {
                        //cpWelcome = await completePage.getElementsById('section_Welcome Message ');
                    //    cpWelcome = await completePage.$eval(('div[id="section_Welcome Message "] > p'), node => node.innerText.trim());
                    //    console.log("ok");
                    } catch (error) {
                    //    cpWelcome;
                    }

                
                    self.page.close();

                    results.push({
                        title1,
                        //siteWeb, 
                        //date, 
                        //lieu, 
                        cpWelcome
                     })

                     
                     
                    

                    
        } 

        let data = JSON.stringify(results, null, 2);
        fs.writeFileSync('./Scrapping/json/confSeries.json', data);   
        return results;
    }
}
module.exports = self;