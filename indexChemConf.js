const chemConf= require('./chemistry-conferences.js');

(async () => {
    await chemConf.initialize();

    let results = await chemConf.getResults(30);

   debugger;

})();