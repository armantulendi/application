package com.project.data.controller;


@Controller
@RequestMapping("connection/servers")
public class ConnectToServers {
    @GetMapping
    public String getConnect(){
        return "connectToServers";
    }
//    @PostMapping("/1")
//    public String firstConnect(@RequestParam(value = "command1") String command, Model model) throws Exception {
//        String  result =Ssh.sshConnect(command,"root","sip-proxy1.dom.loc",22,"QWE@1234");
//
//        model.addAttribute("command1",command);
//        model.addAttribute("result1",result);
//        return "connectToServers";
//    }
//    @PostMapping("/2")
//    public String secondConnect(@RequestParam(value = "command2") String command, Model model) throws Exception {
//        List<String> result=new ArrayList<>();
//           Map<Integer,String> map=Ssh.sshConnect(command,"root","sip-proxy2.dom.loc",22,"QWEdsa@123");
//
//        model.addAttribute("command2",command);
//        model.addAttribute("result2",result);
//        return "connectToServers";
//    }

//
//    @PostMapping("/2")
//    public String postConnect(@RequestParam(value = "command") String command){
//        sshconnect(command);
//        return "connectToServers";
//    }
}
