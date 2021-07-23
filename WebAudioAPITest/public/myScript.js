(
	function() 
	{
  		// Membrane Synth https://tonejs.github.io/docs/r12/MembraneSynth
  		const synth = new Tone.MembraneSynth().toMaster();
  		function playSynth() {
   			synth.triggerAttackRelease("C2", "8n");
  		}
		
		document.querySelector("#soundOnOff").addEventListener("click", function() {
    		playSynth();
  		});
	}
)();
