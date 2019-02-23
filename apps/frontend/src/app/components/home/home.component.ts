import { Component, ElementRef, OnInit, Output } from "@angular/core";
import { interval, Observable, Subscription } from "rxjs";
import { map, share } from "rxjs/operators";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"]
})
export class HomeComponent implements OnInit {

  public loaded: boolean = false;
  public bigSti : boolean;

  public _started: boolean;

  public _countdownEnded: boolean = false;

  public _countdownEnds;
  public _countdownStarts;
  private _diff: number;
  private _startDiff: number;
  private _days: number;
  private _hours: number;
  private _minutes: number;
  private _seconds: number;

  public quotes: Array<string>;

  public quote: string;

  public subText: string;

  constructor() {
    this.quotes=[
      "Heaven is close when Blitzi is near",
      "The love of Blitzi heals",
      "When all else fails, Blitzi is there",
      "Where there is a Blitzi, there is love",
      "No boyfriend is complete without his Blitzi",
      "Blitzi is life, Blitzi is love, Blitzi is happiness",
      "Where there is a Blitzi, there is a way",
      "No love is more powerful than the love of a Blitzi",
      "A Blitzi a day keeps the doctors away",
    ];
  }

  ngOnInit() {
    this._countdownEnds = "2019-02-23:16:00";
    // this._countdownEnds = "2019-02-23:14:44";
    this._countdownStarts = "2019-02-14:12:00";

    this._diff = Date.parse(this._countdownEnds) - Date.parse(new Date().toString());
    this._startDiff = Date.parse(this._countdownStarts) - Date.parse(new Date().toString());
    this._started = true;
    this._days = this.getDays(this._diff);
    this._hours = this.getHours(this._diff);
    this._minutes = this.getMinutes(this._diff);
    this._seconds = this.getSeconds(this._diff);
    this.quote = this.quotes[this._days];


    interval(1000).pipe(map((x) => {
      this._diff = Date.parse(this._countdownEnds) - Date.parse(new Date().toString());
      this._startDiff = Date.parse(this._countdownStarts) - Date.parse(new Date().toString());
    })).subscribe(() => {
      console.log(this._diff);
      this.loaded = true;
      if(this._startDiff > 0){
        this._started = false;
        return;
      }

      if(this._diff < 0){
        this._countdownEnded = true;
        return;
      }

      if(this._days == 0){
        this.subText = "Come back tomorrow for a sorpresa";
      } else {
        this.subText = "Come back tomorrow for a new Blitzi quote of the day";
      }
      this._started = true;
      this._days = this.getDays(this._diff);
      this._hours = this.getHours(this._diff);
      this._minutes = this.getMinutes(this._diff);
      this._seconds = this.getSeconds(this._diff);
      this.quote = this.quotes[this._days];
    });


    interval(2000).subscribe(()=>this.bigSti = !this.bigSti)
  }

  getDays(t){
    return Math.floor( t/(1000*60*60*24) );
  }

  getHours(t){
    return Math.floor( (t/(1000*60*60)) % 24 );
  }

  getMinutes(t){
    return Math.floor( (t/1000/60) % 60 );
  }

  getSeconds(t){
    return Math.floor( (t/1000) % 60 );
  }
}
