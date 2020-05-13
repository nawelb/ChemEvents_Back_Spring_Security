const chemConf= require('./conferenceseriesNumero1.js');

(async () => {
    await chemConf.initialize();

    let results = await chemConf.parseResult();

   debugger;

})();