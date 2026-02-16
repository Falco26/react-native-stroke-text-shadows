import UIKit

class StrokedTextLabel: UILabel {
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

    override init(frame: CGRect) {
        super.init(frame: frame)
        self.numberOfLines = 0
    }

    private var textInsets: UIEdgeInsets = .zero

    public func updateTextInsets() {
        textInsets = UIEdgeInsets(top: outlineWidth, left: outlineWidth, bottom: outlineWidth, right: outlineWidth)
    }

    var outlineWidth: CGFloat = 0
    var outlineColor: UIColor = .clear
    var align: NSTextAlignment = .center
    var customWidth: CGFloat = 0
    var ellipsis: Bool = false
    var shadowLayerColor: UIColor? = nil
    var shadowLayerOffsetX: CGFloat = 0
    var shadowLayerOffsetY: CGFloat = 0
    var shadowLayerRadius: CGFloat = 0
    var shadowLayerOpacity: CGFloat = 1.0


    override func drawText(in rect: CGRect) {
        let shadowOffset = self.shadowOffset
        let textColor = self.textColor

        self.lineBreakMode = ellipsis ? .byTruncatingTail : .byWordWrapping

        let adjustedRect = rect.inset(by: textInsets)

        let context = UIGraphicsGetCurrentContext()
        context?.setLineWidth(outlineWidth)
        context?.setLineJoin(.round)
        context?.setTextDrawingMode(.stroke)
        self.textAlignment = align
        self.textColor = outlineColor

        super.drawText(in: adjustedRect)

        context?.setTextDrawingMode(.fill)
        self.textColor = textColor
        self.shadowOffset = CGSize(width: 0, height: 0)

        if let shadowColor = shadowLayerColor {
            let adjustedColor = shadowColor.withAlphaComponent(shadowLayerOpacity)
            context?.setShadow(offset: CGSize(width: shadowLayerOffsetX, height: shadowLayerOffsetY), blur: shadowLayerRadius, color: adjustedColor.cgColor)
        }

        super.drawText(in: adjustedRect)

        if shadowLayerColor != nil {
            context?.setShadow(offset: .zero, blur: 0, color: nil)
        }

        self.shadowOffset = shadowOffset
    }

    override var intrinsicContentSize: CGSize {
        var contentSize = super.intrinsicContentSize

        let shadowExtraWidth = shadowLayerColor != nil ? abs(shadowLayerOffsetX) + shadowLayerRadius : 0
        let shadowExtraHeight = shadowLayerColor != nil ? abs(shadowLayerOffsetY) + shadowLayerRadius : 0

        if customWidth > 0 {
            contentSize.width = customWidth
        } else {
            contentSize.width += outlineWidth + shadowExtraWidth
        }

        contentSize.height += outlineWidth + shadowExtraHeight
        return contentSize
    }
}
