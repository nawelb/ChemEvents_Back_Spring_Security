var express = require('express');
const apiRouter = express.Router();

//var app = express();
var myGenericMongoClient = require('./my_generic_mongo_client');


//CREATE
// http://localhost:8282/devise-api/private/role-admin/devise en mode post
// avec { "code" : "mxy" , "nom" : "monnaieXy" , "change" : 123 } dans req.body
apiRouter.route('/event-api/private/role-admin/event')
.post( function(req , res  , next ) {
	var nouvelEvent = req.body;
	console.log("POST,nouvelEvent="+JSON.stringify(nouvelEvent));
	nouvelEvent._id=nouvelEvent.title1;
	myGenericMongoClient.genericInsertOne('eventtest',
                                            nouvelEvent,
									     function(err,event){
										     res.send(nouvelEvent);
									    });
});

//UPDATE
// http://localhost:8282/devise-api/private/role-admin/devise en mode PUT
// avec { "code" : "USD" , "nom" : "Dollar" , "change" : 1.123 } dans req.body
apiRouter.route('/event-api/private/role-admin/event')
.put( function(req , res  , next ) {
	var newValueOfEventToUpdate = req.body;
	console.log("PUT,newValueOfEventToUpdate="+JSON.stringify(newValueOfEventToUpdate));
	myGenericMongoClient.genericUpdateOne('eventtest',
	newValueOfEventToUpdate.code ,
	{ nom : newValueOfEventToUpdate.nom , 
	  change : newValueOfEventToUpdate.change} ,
	function(err,event){
			if(err){
				res.status(404).json({ error : "no devise to update with code=" + newValueOfEventToUpdate.code });
			}else{
					res.send(newValueOfEventToUpdate);
			 }
	});	//end of genericUpdateOne()
});

//DELETE BY TITLE1
/*
//work well, commented to test other delete function
// http://localhost:8282/devise-api/private/role-admin/devise/EUR en mode DELETE
apiRouter.route('/event-api/private/role-admin/event/:title1')
.delete( function(req , res  , next ) {
	var idEvent = req.params.title1;
	console.log("DELETE,eventId="+idEvent);
	myGenericMongoClient.genericRemove('eventtest',{ title1 : idEvent },
									     function(err,event){
										     res.send({ deletedEvent : idEvent } );
									    });
});
*/
//DELETE BY ID
// http://localhost:8282/devise-api/private/role-admin/devise/EUR en mode DELETE
apiRouter.route('/event-api/private/role-admin/event/:_id')
.delete( function(req , res  , next ) {
	var idEvent = req.params._id;
	console.log("DELETE,eventId="+idEvent);
	myGenericMongoClient.genericRemove('eventtest',{ _id : idEvent },
									     function(err,event){
										     res.send({ deletedEvent : idEvent } );
									    });
});


//GET ALL
//exemple URL: http://localhost:8282/devise-api/public/devise (returning all devises)
//             http://localhost:8282/devise-api/public/devise?changeMini=1.05
apiRouter.route('/event-api/public/event')
.get( function(req , res  , next ) {
	//var changeMini = req.query.changeMini;
	var mongoQuery = { } ;
	myGenericMongoClient.genericFindList('eventtest',mongoQuery,function(err,event){
		   res.send({mongoQuery : event});
	});//end of genericFindList()
});



//exemple URL: http://localhost:8282/devise-api/public/devise/EUR
apiRouter.route('/event-api/public/event/:_id')
.get( function(req , res  , next ) {
	var idEvent = req.params._id;
	myGenericMongoClient.genericFindOne('eventtest',
										{ '_id' : idEvent },
									    function(err,event){
										   res.send({idEvent : event});
									   });
	
});

exports.apiRouter = apiRouter;