const scf= require('./scf.js');

(async () => {
    await scf.initialize('node');

    let results = await scf.getReslults(30);

   debugger;

})();