// create a bass drum synth

	const synth = new Tone.MembraneSynth().toDestination();

// create a sample player
//	const sampler = new Tone.Sampler({
//	
//		urls: {
//			"C4": "clave.wav"			
//		},
//		release: 1,
//		baseUrl: "http://ogyc.infinityfreeapp.com/",
//	}).toDestination();
	
	
// play a note every quarter-note on the sampler
	
//	const loop = new Tone.Loop(time => {
//	Tone.loaded().then(() => {
//		sampler.triggerAttackRelease(["C4", "C4"], 2);
//	})
	
	// Draw.schedule takes a callback and a time to invoke the callback
//			Tone.Draw.schedule(() => {
//				const noteElement = document.getElementById("rhythmRow");
//				noteElement.classList.remove("invisible");
//				noteElement.classList.add("visible");
//				setTimeout(() => {
//					noteElement.classList.remove("visible");
//					noteElement.classList.add("invisible");
//				}, 400);
//			}, time);
//			
//	}, "4n").start(0);

	
// the loop starts when the Transport is started. Transport is controlled by html button element.
 	// play a note every quarter-note on the bass drum synth

	const part = new Tone.Part(function(time, pitch){
	synth.triggerAttackRelease(pitch, "8n", time);
	
	
	// Draw.schedule takes a callback and a time to invoke the callback
			Tone.Draw.schedule(() => {
				const noteElement = document.getElementById("rhythmRow1");
				noteElement.classList.remove("invisible");
				noteElement.classList.add("visible");
				setTimeout(() => {
					noteElement.classList.remove("visible");
					noteElement.classList.add("invisible");
				}, 150);
			}, time);

		
	}, [["0", "C2"], ["4n", "C2"], ["4n.", "C2"]]).start(0);
	
	//set the note to loop every half measure

part.set({
	"loop" : true,
	"loopEnd" : "2n"
});
	
	
 	
 	let playing = false;
  	
  	document.querySelector("#rhythm1").addEventListener("click", function() {
  	
  
    	
		if (!playing) {
 			Tone.start();
 			Tone.Transport.start();
  			playing = true;
  			Tone.Transport.bpm.value = 80;
  		
		} else {
  			Tone.Transport.stop();
  			playing = false;
		}
	})
	
	
	
	

    	

	

	
	


