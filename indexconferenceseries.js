const chemConf= require('./conferenceseries.js');

(async () => {
    await chemConf.initialize();

    let results = await chemConf.parseResult();

   debugger;

})();