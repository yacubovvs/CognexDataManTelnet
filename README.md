# CognexDataManTelnet
Cognex Dataman example for Java connecting via telnet for continuous reading

In DataMan Utility:
1. Change Trigger Type to Presentation (internal) or `||>SET TRIGGER.TYPE 1\r\n` command on telnet
2. Setting not to read barcode two times
3. Set static ip to the Camera
4. Format data switch to the `Script-Based Formatting`
5. Added script in `Sripting`->`Data Formatting`

```
function onResult (decodeResults, readerProperties, output)
{
	if (decodeResults[0].decoded){
		var mymsg = decodeResults[0].content;
		output.Telnet = "" + mymsg + "\n\r";
		output.content = mymsg;
	}
	else
	{
		output.content = "bad read\n\r";
	}
}
```  

