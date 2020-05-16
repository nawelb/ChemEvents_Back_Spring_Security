//load in puppeteer 
const puppeteer = require('puppeteer')
const fs = require('fs')

const SUBSCF_URL = (scf) => 'https://www.societechimiquedefrance.fr/spip.php?page=manifestation#/${scf}/'

const self ={
 
    browser: null,
    page: null, 
    initialize: async (scf) => {
        self.browser = await puppeteer.launch({
            headless: false
        });

        self.page = await self.browser.newPage();
      
        //Go to the subscf
        await self.page.goto(SUBSCF_URL(scf), {waitUntil: 'networkidle0'});  
        
        await self.page.screenshot({path:'./Scrapping/screenshots/page.png'});        
        //await self.page.pdf({path: './pdfs/page.pdf'});
    }, 

    getResults: async(nr) =>{

       // let results = [];

        //    let elements = await self.page.$$('div[class="ajaxbloc.ajax-id-manif_pagination.bind-ajaxReload"] > nav > ul > li');
            //let results = [];

      //  for (let element of elements){
//
  //          let nextPage = await element.$eval('a', node => node.getAttribute('href'));
//            //await self.page.$(('nav[class="pagination-cont"] > ul[class="pagination"] > li[class="active"] > a:nth-child(n)'), node => node.getElement('href'));
      //      await self.page.goto(nextPage, {waitUntil: 'networkidle0'});
            
            
                //    let new_results = await self.parseResult();

                //    results=[ ...results, ...new_results ];

                //new_results = await self.page.$(('nav[class="pagination-cont"] > ul[class="pagination"] > li[class="active"] > a.bind-ajax'), node => node.getElement('${n}'));
                             
             
    
                //       return results.slice(0, nr)
      


        // let pagenumber = await self.page.$$('ul');
            //let new_results = await self.parseResult();
            let results=[]
            
        do {
            
                let new_results = await self.parseResult();
                //await page.waitForSelector('li:nth-child(${pageN}) > .bind-ajax')
               try {
                await self.page.click('body > div.container.bg-blanc > section:nth-child(1) > div > div.col-xs-12.col-md-offset-1.col-md-6 > div.ajaxbloc.ajax-id-manif_pagination.bind-ajaxReload > nav > ul > li.active + li > a')
                results=[ ...results, ...new_results ];
            } catch (error) {
                console.log("click not working")   
              }
               
                
               
                results.push({
                new_results  
                })
            
            
        } while (results.length < nr);
        

    },

    parseResult: async () => {


        let elements = await self.page.$$('article');
        let results = [];

        for (let element of elements){
        //Element du Header
            let title1 = await element.$eval(('h3'), node => node.innerText.trim());
            let title2 = await element.$eval(('span'), node => node.innerText.trim());
            let date = await element.$eval(('div[class="caractencadre-spip date"]'), node => node.innerText.trim());
            let lieu = await element.$eval(('div[class="lieu"]'), node => node.innerText.trim());

            let img1 = null;
            let img2 = null; 

                try{
                    img1 = await element.$eval('h3 > img:nth-child(1)', node => node.getAttribute('src'));
                    img2 = await element.$eval('h3 > img:nth-child(2)', node => node.getAttribute('src'));
                }catch{
                    img1;
                    img2;    
                }

        //Element du Main

            //let description = await element.$eval(('p'), node => node.innerText.trim());
            let description = null;
            let tags = null;
            let email = null; 
            let siteWeb = null;
                        
            try{
                description = await element.$eval('main > div > p', node => node.innerText.trim());
                tags = await element.$eval('main > div', node => node.innerText.trim());
                email = await element.$eval('main > div > a[class="spip_mail"]', node => node.innerText.trim());
                siteWeb = await element.$eval('main > div > a[class="spip_out"]', node => node.getAttribute('href'));
            
            }catch{
                description;
                email;
                siteWeb;
                tags;
            }
    
            try{
                tags = await element.$eval('main > div:nth-child(2)', node => node.innerText.trim());
                email = await element.$eval('main > div:nth-child(2) > a[class="spip_mail"]', node => node.innerText.trim());
                siteWeb = await element.$eval('main > div:nth-child(2) > a[class="spip_out"]', node => node.getAttribute('href'));
            
            }catch{  
                email;
                siteWeb;   
                tags;
            }

            try{
                email = await element.$eval('main > div:nth-child(3) > a[class="spip_mail"]', node => node.innerText.trim());
                siteWeb = await element.$eval('main > div:nth-child(3) > a[class="spip_out"]', node => node.getAttribute('href'));
            
            }catch{ 
                email;
                siteWeb;  
            }

            results.push({
                img1,
                img2, 
                title1, 
                title2,
                description,
                date, 
                lieu, email, 
                siteWeb, 
                tags
             })
            
             let data = JSON.stringify(results, null, 2);
             fs.writeFileSync('./Scrapping/json/scfArticles.json', data);

        }
       
        return results;
        
    
        
    
    }
 
}



module.exports = self;