// create a bass drum synth

	const synth = new Tone.MembraneSynth().toDestination();

// create a sample player
//	const sampler = new Tone.Sampler({
//		urls: {
//			"C4": "C4.mp3"
//
//		},
//		release: 1,
//		baseUrl: "https://tonejs.github.io/audio/salamander/",
//	}).toDestination();
	
	

// play a note every quarter-note on the bass drum synth
	
	const loop = new Tone.Loop(time => {
	synth.triggerAttackRelease("C2", "8n", time);
	
	// Draw.schedule takes a callback and a time to invoke the callback
			Tone.Draw.schedule(() => {
				const noteElement = document.getElementById("square");
				noteElement.classList.remove("squareOff");
				noteElement.classList.add("squareOn");
				setTimeout(() => {
					noteElement.classList.remove("squareOn");
					noteElement.classList.add("squareOff");
				}, 100);
			}, time);

		
	}, "4n").start(0);
	
// play a note every quarter-note on the sampler
	
//	const loop = new Tone.Loop(time => {
//	Tone.loaded().then(() => {
//		sampler.triggerAttackRelease(["Eb4", "G4", "Bb4"], 4);
//	})
//	}, "4n").start(0);

	
// the loop starts when the Transport is started. Transport is controlled by html button element.
 
 	let playing = false;
  	
  	document.querySelector("#soundOnOff").addEventListener("click", function() {
    	
		if (!playing) {
 			Tone.Transport.start();
 			Tone.start();
  			playing = true;
  			Tone.Transport.bpm.value = 120;
  		
		} else {
  			Tone.Transport.stop();
  			playing = false;
		}
	})
	
	


