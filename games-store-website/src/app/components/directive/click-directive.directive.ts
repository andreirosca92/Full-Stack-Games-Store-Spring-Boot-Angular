import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appClickDirective]'
})
export class ClickDirectiveDirective {

  constructor(private renderer: Renderer2, private elemRef: ElementRef) {}

  ngAfterViewInit() {
    this.renderer.listen(this.elemRef.nativeElement, 'click', (evt) => {
      console.log('Global click evt:', evt.target);
    });
  }

}
