

#import "ViewController.h"
#import <TMM/TMM.h>

@interface ViewController ()
@property (nonatomic, strong) TMMKMMShadowView *shadowView;
@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    self.view.backgroundColor = [UIColor whiteColor];
    self.shadowView = [TMMShadowViewBaseFactoryKt getUserCenterShadowView];
    UIView *renderView = [self.shadowView getUIView];
    [self.view addSubview:renderView];
    [self layoutRenderView];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
}

- (void)viewWillLayoutSubviews {
    [super viewWillLayoutSubviews];
    [self layoutRenderView];
}

- (void)layoutRenderView {
    CGFloat width = CGRectGetWidth(self.view.frame);
    CGFloat height = CGRectGetHeight(self.view.frame);
    [self.shadowView setViewFrameWithOriginX:0 originY:0 width:width height:height];
}

@end
