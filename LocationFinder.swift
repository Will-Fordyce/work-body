//
//  LocationManager.swift
//  PG6f
//
//  Created by Will Fordyce on 12/15/23.
//

import Foundation
import CoreLocation

class LocationFinder: NSObject, CLLocationManagerDelegate {
    static let shared = LocationFinder()
    
    let manager = CLLocationManager()
    var completion: ((CLLocation) -> Void)?
    
    public func getLocation(completion:@escaping(CLLocation)->Void) {
        self.completion = completion
        manager.requestWhenInUseAuthorization()
        manager.delegate = self
        manager.startUpdatingLocation()
    }
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        guard let location = locations.first 
        else {
            return
        }
        completion?(location)
        manager.stopUpdatingLocation()
    }
}
