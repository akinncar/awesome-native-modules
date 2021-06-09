import Foundation

@objc(RNShare)
class RNShare : NSObject {
  
  @objc static func requiresMainQueueSetup() -> Bool {
      return false
  }
  
  // Reference to use main thread
  @objc func open(_ options: NSDictionary) -> Void {
    DispatchQueue.main.async {
      self._open(options: options)
    }
  }
  
  func _open(options: NSDictionary) -> Void {
    var items = [String]()
    let message = RCTConvert.nsString(options["message"])
    
    if message != "" {
      items.append(message!)
    }
    
    if items.count == 0 {
      print("No `message` to share!")
      return
    }
    
    let controller = RCTPresentedViewController();
    let shareController = UIActivityViewController(activityItems: items, applicationActivities: nil);
    
    shareController.popoverPresentationController?.sourceView = controller?.view;
    
    controller?.present(shareController, animated: true, completion: nil)
  }
}
