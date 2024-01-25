//
//  InitialView.swift
//  PG6f
//
//  Created by Will Fordyce on 11/24/23.
//


import UIKit
import SwiftUI  //Getting proper imorts
import WebKit

class InitialView: UIViewController {   //View controller user sees upon app launch
    
    @IBOutlet var TitleLabel:UILabel?
    @IBOutlet var SubtitleLabel:UILabel?
    @IBOutlet var CoordinatePrompt:UILabel?
    @IBOutlet var WebView:WKWebView?        //Declaring variables to be used in this view controller
    var LatitudeTextField:UITextField?
    var LongitudeTextField:UITextField?
    var FindButton:UIButton?
    var mapView:MapView?
    
    override func viewDidLoad() {   //Loading view controller and adding basic styling
        super.viewDidLoad()
        view.backgroundColor = .systemGray2
        
        TitleLabel = UILabel()
        TitleLabel!.text = "The CFF!"
        TitleLabel!.font = UIFont.systemFont(ofSize: 50)    //Styling, framing, an adding the title to the view
        TitleLabel!.textColor = .systemYellow
        TitleLabel!.textAlignment = .center
        TitleLabel!.backgroundColor = .systemRed
        TitleLabel!.frame = CGRect(x:view.frame.size.width/8,y:view.frame.size.height/8,width:view.frame.size.width*(3/4),height:view.frame.size.height/8)
        TitleLabel!.layer.cornerRadius = 10
        TitleLabel!.layer.masksToBounds = true
        view!.addSubview(TitleLabel!)
        
        SubtitleLabel = UILabel()
        SubtitleLabel!.text = "(Chinese Food Finder)"
        SubtitleLabel!.font = UIFont.systemFont(ofSize: 20) //Styling, framing, an adding the subtitle to the view
        SubtitleLabel!.textColor = .systemYellow
        SubtitleLabel!.textAlignment = .center
        SubtitleLabel!.backgroundColor = .systemRed
        SubtitleLabel!.frame = CGRect(x:view.frame.size.width*(3.5/16),y:view.frame.size.height*(7/32),width:view.frame.size.width*(9/16),height:view.frame.size.height/16)
        SubtitleLabel!.layer.cornerRadius = 10
        SubtitleLabel!.layer.masksToBounds = true
        view!.addSubview(SubtitleLabel!)
        
        CoordinatePrompt = UILabel()
        CoordinatePrompt!.text = "Enter Coordinates Below:"
        CoordinatePrompt!.font = UIFont.systemFont(ofSize: 20)  //Styling, framing, an adding the prompt to the view
        CoordinatePrompt!.textAlignment = .center
        CoordinatePrompt!.frame = CGRect(x:view.frame.size.width/8,y:view.frame.size.height/2,width:view.frame.size.width*(3/4),height:view.frame.size.height/16)
        view!.addSubview(CoordinatePrompt!)
        
        LatitudeTextField = UITextField()
        LatitudeTextField!.placeholder = "Enter Latitude"
        LatitudeTextField!.backgroundColor = .systemGray6   //Styling, framing, an adding the latitude text field to the view
        LatitudeTextField!.borderStyle = .roundedRect
        LatitudeTextField!.frame = CGRect(x: view.frame.size.width/8, y: view.frame.size.height*(19/32), width: view.frame.size.width*(3/4), height:view.frame.size.height/16)
        view.addSubview(LatitudeTextField!)
        
        LongitudeTextField = UITextField()
        LongitudeTextField!.placeholder = "Enter Longitude"
        LongitudeTextField!.backgroundColor = .systemGray6  //Styling, framing, an adding the longitude text field to the view
        LongitudeTextField!.borderStyle = .roundedRect
        LongitudeTextField!.frame = CGRect(x: view.frame.size.width/8, y: view.frame.size.height*(22/32), width: view.frame.size.width*(3/4), height:view.frame.size.height/16)
        view.addSubview(LongitudeTextField!)
        
        FindButton = UIButton(type: .system)
        FindButton!.backgroundColor = .systemYellow
        FindButton!.setTitleColor(.black, for: .normal)
        FindButton!.setTitle("Show Result", for: .normal)   //Styling, framing,and adding functionality to the button as well as adding it to the view
        FindButton!.titleLabel?.font = UIFont.systemFont(ofSize: 20)
        FindButton!.frame = CGRect(x: view.frame.size.width*(2.5/8), y: LongitudeTextField!.frame.maxY + 20, width: view.frame.size.width*(3/8), height: 40)
        FindButton!.layer.cornerRadius = 10
        FindButton!.layer.masksToBounds = true
        FindButton!.addTarget(self, action: #selector(goToMap), for: .touchUpInside)
        view.addSubview(FindButton!)
    }
    
    @objc func goToMap() {  //Activated when the button is clicked, jumps to new view with google map search
        

        mapView = MapView()
        let lat = LatitudeTextField?.text ?? ""
        let long = LongitudeTextField?.text ?? ""   //Declaring any needed classes, contants, or variables
        if let latitude = Double(lat), let longitude = Double(long) {   //Converting coordinates to doubles to be corrected if needed and continuing if successful
            if latitude > 90 || latitude < -90 { //If latitude is invalid, it uses the default location which is the device location
                let goTo2 = "https://www.google.com/maps/search/chinese+restaurant/@,16z"
                _ = mapView!.view
                let Url = URL (string:goTo2)
                let RequestObject = URLRequest (url:Url!)
                mapView!.WebView!.load(RequestObject)
                self.present(mapView!, animated: true, completion: nil)
            }
            else {
                let latitudeString = String(latitude)
                let longitudeString = String(longitude) //Creating url out of finalized data and loading it into a web view to be shown in the next view controller
                //testing lat with (40.712862)
                //testing long with (-73.991123)
                let coords = latitudeString + "," + longitudeString
                let goTo = "https://www.google.com/maps/search/chinese+restaurant/@" + coords + ",16z"
                _ = mapView!.view
                let Url = URL (string:goTo)
                let RequestObject = URLRequest (url:Url!)
                mapView!.WebView!.load(RequestObject)
                self.present(mapView!, animated: true, completion: nil)
            }
       }
        else {
                print("Invalid latitude or longitude format")   //Printing error if string couldn't be converted to double
                return
            }
    }

}

