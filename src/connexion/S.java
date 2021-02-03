/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;
import net.sourceforge.javaflacencoder.FLACFileWriter;

/**
 *
 * @author DELL
 */
public class S implements GSpeechResponseListener {
String T="";
final Microphone mic = new Microphone(FLACFileWriter.FLAC);
		//Don't use the below google api key , make your own !!! :) 
		GSpeechDuplex duplex = new GSpeechDuplex("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
static String output = "";
    public S() {
    }
		
                
                
	public void Recon()
        {output="";
            duplex.setLanguage("fr");
		new Thread(() -> {
					try {
						duplex.recognize(mic.getTargetDataLine(), mic.getAudioFormat());
					} catch (Exception ex) {
						 System.out.println("Kdeeem");
					}
					
				}).start();
                
                duplex.addResponseListener(new GSpeechResponseListener() {
			String old_text = "";
                    
			public void onResponse(GoogleResponse gr) {
				
				output = gr.getResponse();
				if (gr.getResponse() == null) {
					this.old_text = T;
					if (this.old_text.contains("(")) {
						this.old_text = this.old_text.substring(0, this.old_text.indexOf('('));
					}
					System.out.println("Paragraph Line Added");
					this.old_text = ( T+ "\n" );
					this.old_text = this.old_text.replace(")", "").replace("( ", "");
					T=this.old_text;
					return;
				}
				if (output.contains("(")) {
					output = output.substring(0, output.indexOf('('));
				}
				if (!gr.getOtherPossibleResponses().isEmpty()) {
					output = output + " (" + (String) gr.getOtherPossibleResponses().get(0) + ")";
				}
				System.out.println(output);
				T="";
				T+=(this.old_text);
				T+=(output);
			}
		});
                
                
        }
        
        public void Recoff()
        {
            mic.close();
	duplex.stopSpeechRecognition();
            
        }

    public String getOutput() {
        return output;
    }

    public String getT() {
        return T;
    }
    
    
        
        

    
    
    @Override
    public void onResponse(GoogleResponse gr) {
        
    }
    
}
