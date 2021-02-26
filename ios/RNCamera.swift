import Foundation
import AVFoundation

protocol RNCameraDelegate {
  func onTouch(data: NSDictionary)
}

class RNCamera : UIView {

  let sessionQueue = dispatch_queue_serial_t(label: "cameraQueue")
  let session = AVCaptureSession()
  var previewLayer: AVCaptureVideoPreviewLayer

  required init?(coder: NSCoder) {
    previewLayer = AVCaptureVideoPreviewLayer(session: session)
    super.init(coder: coder)
    initialize()
  }

  override init(frame: CGRect) {
    previewLayer = AVCaptureVideoPreviewLayer(session: session)
    super.init(frame: frame)
    initialize()
  }

  override func layoutSubviews() {
    super.layoutSubviews()
    previewLayer.frame = bounds
    backgroundColor = UIColor.blue
    layer.insertSublayer(previewLayer, at: 0)
  }

  override func insertReactSubview(_ subview: UIView!, at atIndex: Int) {
    insertSubview(subview, at: atIndex + 1)
    super.insertReactSubview(subview, at: atIndex)
  }

  override func removeReactSubview(_ subview: UIView!) {
    subview.removeFromSuperview()
    super.removeReactSubview(subview)
  }

  private func initialize() {
    previewLayer.videoGravity = AVLayerVideoGravity.resizeAspectFill
    previewLayer.needsDisplayOnBoundsChange = true
  }
}
