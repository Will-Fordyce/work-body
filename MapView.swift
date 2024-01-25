//
//  MapView.swift
//  PG6f
//
//  Created by Will Fordyce on 11/24/23.
//

import UIKit
import WebKit   //Importing relevent items

class MapView: UIViewController {   //Second view controller which displays the contents of the url
    
    var latitude: String = ""
    var longitude: String = ""
    @IBOutlet var WebView:WKWebView?    //Creating neccessary variables for view controller
    var BackButton:UIButton?
    
    override func viewDidLoad() {   //Loading view controller and adding basic styling
        super.viewDidLoad()
        view.backgroundColor = .systemBackground
        
        WebView = WKWebView()   //Framing web view and adding it to the view controller
        WebView!.frame = CGRect(x:0,y:0,width:view.frame.size.width,height:view.frame.size.height*(3/4))
        view.addSubview(WebView!)
        
        BackButton = UIButton(type: .system)
        BackButton!.backgroundColor = .systemRed
        BackButton!.setTitleColor(.yellow, for: .normal)    //Styling, framing, and adding functionality to the return button as well as adding it to the view controller
        BackButton!.setTitle("Back", for: .normal)
        BackButton!.titleLabel?.font = UIFont.systemFont(ofSize: 20)
        BackButton!.frame = CGRect(x:view.frame.size.width/8, y:WebView!.frame.maxY + 20, width:view.frame.size.width*(3/4), height:view.frame.size.height/16)
        BackButton!.layer.cornerRadius = 10
        BackButton!.layer.masksToBounds = true
        BackButton!.addTarget(self, action: #selector(goBack), for: .touchUpInside)
        view.addSubview(BackButton!)
    }
    
    @objc func goBack() {   //Takes user back to first view controller where they can enter in new coordinates if they would like
        let initialView = InitialView()
        self.present(initialView, animated: true, completion: nil)
    }
}
