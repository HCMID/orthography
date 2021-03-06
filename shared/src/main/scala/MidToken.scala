package edu.holycross.shot.mid.orthography
import scala.scalajs.js.annotation._
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._


/** A classified token.
*
* @param urn Exemplar-level CtsUrn identifying the token.
* @param s String value of token.
* @param tokenCategory `None` if string cannot
* be analyzed; otherwise, `Option` of a
* `MidTokenCategory` recognized by an [MidOrthography]'s
* `tokenCategories` function.
*/
@JSExportAll case class MidToken(urn: CtsUrn, string: String, tokenCategory: Option[MidTokenCategory]) {

  /**  Create a `CitableNode` from this token.
  */
  def citableNode: CitableNode = CitableNode(urn, string)
  def text = string
}
